import org.apache.maven.plugin.testing.MojoRule;
import org.apache.maven.plugin.testing.WithoutMojo;

import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.File;

import net.wouterdanes.MustacheMojo;

public class MustacheMojoHarnessTest {

    @Rule
    public MojoRule rule = new MojoRule() {
      @Override
      protected void before() throws Throwable {
      }

      @Override
      protected void after() {
      }
    };

    /**
     * @throws Exception if any
     */
    @Test
    public void testIncludesPath() throws Exception  {
        File pom = new File("src/test/resources/testing-harness/pom.xml");
        assertNotNull( pom );
        assertTrue( pom.exists() );

        MustacheMojo myMojo = (MustacheMojo) rule.lookupMojo( "mustache", pom );
        assertNotNull( myMojo );
        myMojo.execute();
    }
}