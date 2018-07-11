//
// Helper to checkout, update, commit and push Maven-generated site content for GH-Pages.
//

// FIXME: ATM only supports github SSH repository urls
// TODO: allow configuration to be passed in from pom

boolean dryRun = properties.getProperty('dryRun', 'false') as boolean
log.info "Dry run: $dryRun"

def siteUrl = project?.distributionManagement?.site?.url
log.info "Site URL: $siteUrl"
assert siteUrl

def gitRepository = siteUrl - 'scm:git:ssh://git@github.com/'
log.info "GIT repository: $gitRepository"

def gitUrl = "git@github.com:$gitRepository"
log.info "GIT URL: $gitUrl"

def gitBranch = properties.getProperty('gitBranch', 'gh-pages')
log.info "GIT Branch: $gitBranch"

def targetDir = new File(project.build.directory as String)
log.info "Target directory: $targetDir"

def hugoPublicDir = new File(targetDir, 'hugo-public')
log.info "Hugo public directory: $hugoPublicDir"
assert hugoPublicDir.exists()

//def stagingDir = new File(targetDir, 'staging')
//log.info "Staging directory: $stagingDir"
//assert stagingDir.exists()

def checkoutDir = new File(targetDir, 'publish-checkout')
log.info "Checkout directory: $checkoutDir"
if (checkoutDir.exists()) {
  ant.delete(dir: checkoutDir)
}
ant.mkdir(dir: checkoutDir)

// helper to run a task surrounded by snippet markers
def snippet = { Closure task ->
  println '----8<----'
  task.run()
  println '---->8----'
}

log.info "Cloning $gitUrl ($gitBranch branch) to: $checkoutDir"
snippet {
  ant.exec(executable: 'git', dir: checkoutDir) {
    arg(value: 'clone')
    arg(value: '--branch')
    arg(value: gitBranch)
    arg(value: gitUrl)
    arg(value: '.')
  }
}

def mavenDir = new File(checkoutDir, 'maven')
log.info "Maven directory: $mavenDir"

if (mavenDir.exists()) {
  log.info "Removing existing content from $mavenDir"
  ant.exec(executable: 'git', dir: checkoutDir, failonerror: true) {
    arg(value: 'rm')
    arg(value: '-r')
    arg(value: '--quiet')
    arg(value: mavenDir.name)
  }
}
ant.mkdir(dir: mavenDir)

log.info "Copying generated content to: $mavenDir"
ant.copy(todir: mavenDir) {
  fileset(dir: hugoPublicDir) {
    include(name: '**')
  }
//  fileset(dir: stagingDir) {
//    include(name: '**')
//  }
}

log.info 'Adding changed files'
ant.exec(executable: 'git', dir: checkoutDir, failonerror: true) {
  arg(value: 'add')
  arg(value: mavenDir.name)
}

log.info 'Checking status'
ant.exec(executable: 'git', dir: checkoutDir, failonerror: true, outputproperty: 'git-status') {
  arg(value: 'status')
  arg(value: '--short')
}
def status = ant.project.properties.'git-status'.trim()

if (status) {
  snippet { println status }

  log.info 'Committing changes'
  snippet {
    ant.exec(executable: 'git', dir: checkoutDir, failonerror: true) {
      arg(value: 'commit')
      arg(value: '-m')
      arg(value: 'Maven-generated site content refresh')
    }
  }

  if (!dryRun) {
    log.info 'Pushing changes'
    snippet {
      ant.exec(executable: 'git', dir: checkoutDir, failonerror: true) {
        arg(value: 'push')
        arg(value: 'origin')
        arg(value: gitBranch)
      }
    }
  }
}
else {
  log.info 'No changes detected'
}

log.info 'Done'
