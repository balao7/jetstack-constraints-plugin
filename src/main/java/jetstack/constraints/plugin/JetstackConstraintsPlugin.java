package jetstack.constraints.plugin;

import com.gradle.scan.plugin.BuildScanExtension;
import org.gradle.api.Plugin;
import org.gradle.api.initialization.Settings;

import com.gradle.enterprise.gradleplugin.GradleEnterpriseExtension;
import com.gradle.enterprise.gradleplugin.GradleEnterprisePlugin;

import javax.annotation.Nonnull;

/**
 * Core plugin class for constraints to add pre-default settings for the project.
 */
public class JetstackConstraintsPlugin implements Plugin<Settings> {

    @Override
    public void apply(@Nonnull  Settings settings) {
        settings.getPlugins().withType(GradleEnterprisePlugin.class, plugin -> {
            configureBuildScan(settings);
        });
    }

    private void configureBuildScan(Settings settings) {
        BuildScanExtension buildScan = settings.getExtensions().getByType(GradleEnterpriseExtension.class).getBuildScan();
        buildScan.setTermsOfServiceUrl("https://gradle.com/terms-of-service");
        buildScan.setTermsOfServiceAgree("yes");
    }
}
