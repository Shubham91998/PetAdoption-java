<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <link rel="stylesheet" href="mystyle.css"/>
</head>
<body>
    <h1>Registration Form</h1>
    <form action="register" method="post" onsubmit="return validateForm()">
        <p>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter your full name"/>
            <span id="name-error" class="error-message"></span>    
        </p>

        <p>
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" placeholder="Enter your address"/>
            <span id="address-error" class="error-message"></span>    
        </p>

        <p>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" placeholder="Enter your Email"/>
            <span id="email-error" class="error-message"></span>    
        </p>
        
        <p>
            <label for="mobile">Mobile:</label>
            <input type="number" id="mobile" name="mobile" placeholder="Enter your Mobile"/>
            <span id="mobile-error" class="error-message"></span>    
        </p>

        <p>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your Password"/>
            <span id="password-error" class="error-message"></span>    
        </p>

        <p>
            <label for="confirm_password">Confirm Password:</label>
            <input type="password" id="confirm_password" name="confirm_password" placeholder="Enter your Confirm Password"/>
            <span id="confirm-password-error" class="error-message"></span>    
        </p>

        <p>
            <input type="checkbox" id="agree" name="agree" />
            <label for="agree">I agree to the above information</label>
            <span id="agree-error" class="error-message"></span>   
        </p> 

        <p>
            <input type="submit" value="Submit" name="submit"/>
            <input type="reset" value="Reset" name="reset"/>
        </p>
    </form>

    <script src="myscript.js"></script>
</body>
</html>
