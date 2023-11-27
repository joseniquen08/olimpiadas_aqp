package pe.edu.utp.olimpiadas_aqp.services;

public interface EmailServiceInterface {
    void sendSimpleMessage(String to, String subject, String text);
}
