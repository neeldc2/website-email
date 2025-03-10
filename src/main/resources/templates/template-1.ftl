<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 600px;
            margin: 20px auto;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }
        .header {
            background-color: #007BFF;
            color: #ffffff;
            padding: 20px;
            text-align: center;
        }
        .content {
            padding: 20px;
        }
        .footer {
            background-color: #f4f4f4;
            text-align: center;
            padding: 10px;
            font-size: 12px;
            color: #777777;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            margin: 20px 0;
            background-color: #28a745;
            color: #ffffff;
            text-decoration: none;
            border-radius: 5px;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h1>Welcome to website-email.com!</h1>
        </div>
        <div class="content">
            <h2>Hello ${name},</h2>
            <p>Thank you for signing up with <a href="https://website-email.com">Almameet.com</a>!</p>
	    <p>You email address ${email} has been approved. </p>
            <p>Your registration is now complete. You can now log in to your account and start enjoying our services.</p>
            <p>To get started, click the button below:</p>
            <a href="https://website-email.com/login" class="button">Log In to Your Account</a>
        </div>
        <div class="footer">
            <p>If you have any questions, feel free to <a href="https://website-email.com/contact">contact us</a>.</p>
            <p>&copy; ${currentYear} Your Company. All rights reserved.</p>
        </div>
    </div>
</body>
</html>