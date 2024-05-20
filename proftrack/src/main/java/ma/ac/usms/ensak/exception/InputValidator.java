package ma.ac.usms.ensak.exception;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class InputValidator {

    private static final List<String> ALLOWED_EXTENSIONS = Arrays.asList(
            "doc", "docx", "pdf", "txt", "ppt", "pptx", "xls", "xlsx", "csv");

    public static boolean isValidDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            AlertHandler.showInvalidDateAlert();
            return false;
        }
        if ( startDate.isBefore(LocalDateTime.now())) {
            AlertHandler.showInvalidStartDateAlert();
            return false;
        } else if (startDate.isAfter(endDate)) {
            AlertHandler.showInvalidDateAlert();
            return false;
            
        }
        return true;

    }

    public static boolean isValidDate(Date StaetDate, Date EndDate) {
        if (StaetDate == null || EndDate == null) {
            AlertHandler.showInvalidDateAlert();
            return false;
        }
        if (StaetDate.before(new Date())) {
            AlertHandler.showInvalidStartDateAlert();
            return false;
        } else if (StaetDate.after(EndDate)) {
            AlertHandler.showInvalidDateAlert();
            return false;
        }
        return true;
        
    }

    public static boolean isValidFile(File file) {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        return ALLOWED_EXTENSIONS.contains(extension.toLowerCase());
    }

}
