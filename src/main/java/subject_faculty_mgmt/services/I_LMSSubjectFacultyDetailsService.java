package subject_faculty_mgmt.services;

import java.util.ArrayList;
import subject_faculty_mgmt.model.dto.LMSSubjectFacultyDetailsDTO;

public interface I_LMSSubjectFacultyDetailsService
{
    abstract public LMSSubjectFacultyDetailsDTO newLMSSubjectFacultyDetails(LMSSubjectFacultyDetailsDTO resourceFacultyDetailsDTO);
    abstract public ArrayList<LMSSubjectFacultyDetailsDTO> getAllLMSSubjectFacultyDetailss();    
    abstract public ArrayList<LMSSubjectFacultyDetailsDTO> getSelectLMSSubjects(ArrayList<Long> ids);
    abstract public ArrayList<LMSSubjectFacultyDetailsDTO> getSelectSubjectsByFaculties(ArrayList<Long> ids);
    abstract public void updLMSSubjectFacultyDetails(LMSSubjectFacultyDetailsDTO LMSSubjectFacultyDetailsDTO);
    abstract public void delSelectLMSSubjectByFaculties(ArrayList<Long> ids);
    abstract public void delSelectLMSSubjects(ArrayList<Long> DocumentSeqNos);
    abstract public void delAllLMSSubjectFacultyDetailss();
    
}