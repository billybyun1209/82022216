# 베이스 이미지 설정
FROM cepgbaseacr.azurecr.io/docker.io/openjdk:17-slim

# 작업 디렉토리 설정
WORKDIR /app

# Node.js 설치 (Debian 기반 이미지에서 설치)
RUN apt-get update && apt-get install -y curl \
    && curl -fsSL https://deb.nodesource.com/setup_18.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g npm@latest

# package.json 복사
COPY package.json ./

# 종속성 설치
RUN npm install

# 소스 파일 복사
COPY server.js ./

# 애플리케이션 실행
CMD ["node", "server.js"]
