document.addEventListener("DOMContentLoaded", function() {
    const loginForm = document.getElementById("loginForm"); // 로그인 폼 요소 선택

    loginForm.addEventListener("submit", function(event) {
        event.preventDefault(); // 기본 폼 제출 동작 방지

        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        // 폼 유효성 검사
        if (username === "" || password === "") {
            alert("사용자 이름과 비밀번호를 입력하세요."); // 경고 메시지
            return;
        }

        // AJAX 요청 보내기
        const xhr = new XMLHttpRequest();
        xhr.open("POST", "/login", true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        xhr.onload = function() {
            if (xhr.status === 200) {
                // 로그인 성공 시 리다이렉트
                window.location.href = "/userList"; // 사용자 목록 페이지로 이동
            } else {
                // 로그인 실패 시 메시지 표시
                alert("로그인 실패! 사용자 이름 또는 비밀번호를 확인하세요.");
            }
        };

        // 요청 데이터 전송
        xhr.send(`username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`);
    });
});
