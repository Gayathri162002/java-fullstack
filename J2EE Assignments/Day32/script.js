document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('registrationForm');
    const usernameInput = document.getElementById('username');
    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('password');
    const confirmPasswordInput = document.getElementById('confirm_password');

    const usernameError = document.getElementById('usernameError');
    const emailError = document.getElementById('emailError');
    const passwordError = document.getElementById('passwordError');
    const confirmPasswordError = document.getElementById('confirmPasswordError');

    function showError(input, message, errorElement) {
        errorElement.textContent = message;
        input.classList.add('error');
    }

    function clearError(input, errorElement) {
        errorElement.textContent = '';
        input.classList.remove('error');
    }

    function validateUsername() {
        const username = usernameInput.value.trim();
        if (username === '') {
            showError(usernameInput, 'Username is required', usernameError);
            return false;
        } else {
            clearError(usernameInput, usernameError);
            return true;
        }
    }

    function validateEmail() {
        const email = emailInput.value.trim();
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (email === '') {
            showError(emailInput, 'Email is required', emailError);
            return false;
        } else if (!emailPattern.test(email)) {
            showError(emailInput, 'Invalid email format', emailError);
            return false;
        } else {
            clearError(emailInput, emailError);
            return true;
        }
    }

    function validatePassword() {
        const password = passwordInput.value.trim();
        if (password === '') {
            showError(passwordInput, 'Password is required', passwordError);
            return false;
        } else if (password.length < 8 || password.length > 20) {
            showError(passwordInput, 'Password must be between 8 and 20 characters long', passwordError);
            return false;
        } else {
            clearError(passwordInput, passwordError);
            return true;
        }
    }

    function validateConfirmPassword() {
        const confirmPassword = confirmPasswordInput.value.trim();
        if (confirmPassword === '') {
            showError(confirmPasswordInput, 'Please confirm your password', confirmPasswordError);
            return false;
        } else if (confirmPassword !== passwordInput.value.trim()) {
            showError(confirmPasswordInput, 'Passwords do not match', confirmPasswordError);
            return false;
        } else {
            clearError(confirmPasswordInput, confirmPasswordError);
            return true;
        }
    }

    usernameInput.addEventListener('input', validateUsername);
    emailInput.addEventListener('input', validateEmail);
    passwordInput.addEventListener('input', validatePassword);
    confirmPasswordInput.addEventListener('input', validateConfirmPassword);

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const isUsernameValid = validateUsername();
        const isEmailValid = validateEmail();
        const isPasswordValid = validatePassword();
        const isConfirmPasswordValid = validateConfirmPassword();

        if (isUsernameValid && isEmailValid && isPasswordValid && isConfirmPasswordValid) {
            alert('Form submitted successfully!');
            // Uncomment the following line to submit the form for real
            // form.submit();
        }
    });
});

