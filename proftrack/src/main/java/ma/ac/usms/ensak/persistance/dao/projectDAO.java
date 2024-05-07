/**
 * 
 */
package ma.ac.usms.ensak.persistance.dao;

/**
 * 
 */
import java.util.List;

import ma.ac.usms.ensak.metier.POJO.project;

public interface projectDAO {
    void createproject(project project);
    project readproject(int idproject);
    void updateproject(project project);
    void deleteproject(int idproject);
    List<project> getAllprojects();
    List<project> getprojectsByCategory(String category);
    List<project> getprojectsByType(String type);
}
