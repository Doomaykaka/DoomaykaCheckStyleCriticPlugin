/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package doomaykacheckstylecriticplugin;

import org.gradle.api.Project;

import java.util.Iterator;

import org.gradle.api.Plugin;

public class DoomaykaCheckStyleCriticPluginPlugin implements Plugin<Project> {
    public void apply(Project project) {
        // Register a task
        project.getTasks().register("parseReport", task -> {
            /*
             * Iterator<org.gradle.api.Task> iterator = project.getTasks().iterator();
             * org.gradle.api.Task lastTask = null; while(iterator.hasNext()) {
             * lastTask=iterator.next(); }
             * 
             * task.dependsOn(lastTask);
             */
            
            task.doLast(s -> App.start(new String[0]));
        });
    }
}
