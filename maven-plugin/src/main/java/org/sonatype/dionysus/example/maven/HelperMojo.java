package org.sonatype.dionysus.example.maven;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.apache.maven.project.MavenProject;
import org.apache.maven.settings.Settings;

/**
 * Helper mojo.
 *
 * @since ???
 */
@Mojo(name = "helper", requiresDependencyResolution=ResolutionScope.COMPILE, defaultPhase=LifecyclePhase.GENERATE_RESOURCES)
public class HelperMojo
    extends AbstractMojo
{
  @Parameter(defaultValue = "${project}", readonly = true)
  private MavenProject project;

  @Parameter(defaultValue = "${session}", readonly = true)
  private MavenSession session;

  @Parameter(defaultValue = "${settings}", readonly = true)
  private Settings settings;

  /**
   * Skip execution.
   *
   * @since ???
   */
  @Parameter(property = "helper.skip", defaultValue = "false")
  private boolean skip = false;

  /**
   * Another thingy.
   *
   * @since ???
   */
  @Parameter(defaultValue = "foo", required = true)
  private String anotherThingy;

  @Override
  public void execute() throws MojoExecutionException, MojoFailureException {
    // TODO
  }
}
