FROM ubuntu:24.04

ENV DEBIAN_FRONTEND=noninteractive

# Instala dependências essenciais
RUN apt-get update && apt-get install -y \
    git \
    git-lfs \
    openjdk-21-jdk \
    maven \
    mysql-server \
    curl \
    build-essential \
    && rm -rf /var/lib/apt/lists/*

# Instala Node.js LTS (recomendado para Angular)
RUN curl -fsSL https://deb.nodesource.com/setup_lts.x | bash - \
    && apt-get install -y nodejs \
    && npm install -g @angular/cli

# Configuração inicial do MySQL
RUN echo "CREATE USER 'clara'@'localhost' IDENTIFIED BY 'Senha@123'; \
        GRANT ALL PRIVILEGES ON *.* TO 'clara'@'localhost' WITH GRANT OPTION; \
        CREATE DATABASE projeto; \
        FLUSH PRIVILEGES;" > /tmp/script.sql

RUN service mysql start && \
    sleep 5 && \
    mysql -uroot < /tmp/script.sql && \
    service mysql stop

# Diretório de trabalho
WORKDIR /workspace

# Comando padrão
CMD ["bash"]
