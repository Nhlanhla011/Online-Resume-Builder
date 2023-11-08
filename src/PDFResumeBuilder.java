import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class PDFResumeBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();
        System.out.print("Enter your objective or summary: ");
        String objective = scanner.nextLine();
        System.out.print("Enter your education: ");
        String education = scanner.nextLine();
        System.out.print("Enter your work experience: ");
        String workExperience = scanner.nextLine();
        System.out.print("Enter your skills: ");
        String skills = scanner.nextLine();
        System.out.print("Enter your certifications: ");
        String certifications = scanner.nextLine();
        System.out.print("Enter your languages: ");
        String languages = scanner.nextLine();
        System.out.print("Enter your projects: ");
        String projects = scanner.nextLine();
        System.out.print("Enter your hobbies and interests: ");
        String hobbies = scanner.nextLine();
        System.out.print("Enter references (if any): ");
        String references = scanner.nextLine();

        
        String resumeContent = generateResume(name, email, phone, address, objective, education, workExperience, skills, certifications, languages, projects, hobbies, references);

        
        try {
            generatePDFResume(name+" resume.pdf", resumeContent);
            System.out.println("Your resume has been saved to 'resume.pdf'.");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static String generateResume(String name, String email, String phone, String address, String objective, String education, String workExperience, String skills, String certifications, String languages, String projects, String hobbies, String references) {
        StringBuilder resume = new StringBuilder();

        resume.append("cumulative vitae of " + name + "\n\n");
        resume.append("Name: " + name + "\n");
        resume.append("Email: " + email + "\n");
        resume.append("Phone: " + phone + "\n");
        resume.append("Address: " + address + "\n\n");
        resume.append("Objective/Summary: \n" + objective + "\n\n");
        resume.append("Education: \n" + education + "\n\n");
        resume.append("Work Experience: \n" + workExperience + "\n\n");
        resume.append("Skills: \n" + skills + "\n\n");
        resume.append("Certifications: \n" + certifications + "\n\n");
        resume.append("Languages: \n" + languages + "\n\n");
        resume.append("Projects: \n" + projects + "\n\n");
        resume.append("Hobbies and Interests: \n" + hobbies + "\n\n");
        resume.append("References: \n" + references + "\n");

        return resume.toString();
    }

    public static void generatePDFResume(String filePath, String content) throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        document.add(new Paragraph(content));
        document.close();
    }
}