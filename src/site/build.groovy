//
// Helper to build site
//

boolean rebuildTheme = properties.getProperty('rebuildTheme', 'false').toBoolean()
log.info "Rebuild theme: $rebuildTheme"

boolean generateHugo = properties.getProperty('generateHugo', 'true').toBoolean()
log.info "Generate Hugo: $generateHugo"

boolean generateMaven = properties.getProperty('generateMaven', 'true').toBoolean()
log.info "Generate Maven: $generateMaven"

def targetDir = new File(project.build.directory as String)
log.info "Target directory: $targetDir"

def hugoDir = new File(basedir as File, 'src/site/hugo')
log.info "Hugo directory: $hugoDir"
assert hugoDir.exists()

def themeDir = new File(hugoDir, 'themes/dionysus')
log.info "Theme directory: $themeDir"
assert themeDir.exists()

// helper to run a task surrounded by snippet markers
def snippet = { Closure task ->
  println '----8<----'
  task.run()
  println '---->8----'
}

if (rebuildTheme) {
  log.info 'Rebuilding Hugo theme'
  snippet {
    ant.exec(executable: 'yarn', dir: themeDir, failonerror: true) {
      arg(value: 'build')
    }
  }
}

if (generateHugo) {
  log.info 'Generating Hugo site'
  snippet {
    ant.exec(executable: 'hugo', dir: hugoDir, failonerror: true)
  }
}

if (generateMaven) {
  log.info 'Generating Maven site'
  snippet {
    ant.exec(executable: "$basedir/mvnw", dir: basedir as File, failonerror: true) {
      arg(value: '-Psite-stage')
    }
  }
}

log.info 'Done'
