package com.eight.travel.service;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginAttemptService {
    private static final int MAX_ATTEMPTS = 5;
    private static final long LOCK_TIME_MILLIS = 15 * 60 * 1000; // 15분 잠금

    private final Map<String, Integer> attempts = new ConcurrentHashMap<>();
    private final Map<String, Long> lockTime = new ConcurrentHashMap<>();

    // 로그인 실패 시도 증가
    public void loginFailed(String email) {
        int currentAttempts = attempts.getOrDefault(email, 0) + 1;
        attempts.put(email, currentAttempts);

        if (currentAttempts >= MAX_ATTEMPTS) {
            lockTime.put(email, System.currentTimeMillis()); // 계정 잠금 시간 기록
        }
    }

    // 로그인 성공 시도 초기화
    public void resetAttempts(String email) {
        attempts.remove(email);
        lockTime.remove(email);
    }

    // 계정이 잠겼는지 확인
    public boolean isBlocked(String email) {
        if (!lockTime.containsKey(email)) {
            return false;
        }

        long lockStartTime = lockTime.get(email);
        if (System.currentTimeMillis() - lockStartTime > LOCK_TIME_MILLIS) {
            // 15분이 지나면 계정 잠금 해제
            resetAttempts(email);
            return false;
        }
        return true;
    }
}
