package dev.aman.job_portal_userservice.Utilities;

public class OTPData {

    public static String getMessageBody(String otp, String name) {
        return "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "<title>OTP Verification</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; background-color: #f4f7fa; margin: 0; padding: 0; }" +
                ".email-container { width: 100%; max-width: 600px; margin: 0 auto; background-color: #ffffff; border: 1px solid #dddddd; border-radius: 10px; padding: 30px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }" +
                ".email-header { text-align: center; color: #1c7ed6; }" +
                ".otp-code { font-size: 30px; font-weight: bold; color: #333; text-align: center; padding: 20px 0; }" +
                ".email-footer { text-align: center; font-size: 12px; color: #777777; }" +
                ".button { display: inline-block; padding: 12px 30px; font-size: 16px; color: #ffffff; background-color: #1c7ed6; text-decoration: none; border-radius: 5px; margin-top: 20px; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"email-container\">" +
                "<div class=\"email-header\">" +
                "<h2>OTP Verification</h2>" +
                "</div>" +
                "<div class=\"email-body\">" +
                "<p>Hello "+name+",</p>" +
                "<p>We received a request to send you a One-Time Password (OTP) for verification. Please use the OTP below to complete your action:</p>" +
                "<div class=\"otp-code\">" +
                "<strong>" + otp + "</strong>" +
                "</div>" +
                "<p>The OTP is valid for 5 minutes. If you did not request this, please ignore this message.</p>" +
                "<a href=\"#\" class=\"button\">Verify Now</a>" +
                "</div>" +
                "<div class=\"email-footer\">" +
                "<p>If you have any questions, feel free to contact our support team.</p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
