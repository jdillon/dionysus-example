package org.sonatype.dionysus.example.maven;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.settings.Settings;

@Mojo(name = "helper")
public class HelperMojo
    extends AbstractMojo
{
  @Parameter(defaultValue = "${project}", readonly = true)
  private MavenProject project;

  @Parameter(defaultValue = "${session}", readonly = true)
  private MavenSession session;

  @Parameter(defaultValue = "${settings}", readonly = true)
  private Settings settings;

  @Parameter(property = "helper.skip", defaultValue = "false")
  private boolean skip = false;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    // TODO
  }
}
