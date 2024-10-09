# 베이스 이미지 설정
FROM cepgbaseacr.azurecr.io/docker.io/openjdk:17-slim

# 작업 디렉토리 설정
WORKDIR /app

# 프로젝트 파일 복사
COPY package.json ./
COPY server.js ./

# 종속성 설치
RUN npm install

# 애플리케이션 실행
CMD ["node", "server.js"]

# 포트 노출
EXPOSE 8080
