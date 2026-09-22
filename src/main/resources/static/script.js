document.getElementById("loginForm").addEventListener("submit", function(event) {

    event.preventDefault();

    document.getElementById("message").innerText =
        "Login system will be connected soon.";

});