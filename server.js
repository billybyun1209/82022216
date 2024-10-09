const express = require('express'); // express 모듈 불러오기
const app = express(); // express 애플리케이션 생성
const port = 8080; // 사용할 포트 번호

// GET API 작성
app.get('/api/v1/user', (req, res) => {
    const userId = req.query.id; // 쿼리 파라미터에서 사번 가져오기
    if (userId) {
        res.json({ id: userId }); // 사번 리턴
    } else {
        res.status(400).json({ error: '사번을 제공해 주세요.' }); // 사번이 없을 경우 에러 리턴
    }
});

// 서버 시작
app.listen(port, () => {
    console.log(`서버가 http://localhost:${port}에서 실행 중입니다.`); // 서버 실행 메시지
});
