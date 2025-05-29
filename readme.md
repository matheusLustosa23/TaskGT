<!-- o que faz?
com que o que foi construido?
e por que foi construido? -->



# TaskGT
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Vite](https://img.shields.io/badge/vite-%23646CFF.svg?style=for-the-badge&logo=vite&logoColor=white)
![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)
![Tailwind css](https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)


<!-- desc -->
TaskGt is a task manager designed to provide an intuitive and versatile experience. It allows users to create, customize, and track their tasks easily, helping them stay organized and boost their productivity.
The main goal of this project is to offer an efficient tool for managing daily routines with simplicity and effectiveness.



## 🗂️ Conceptual Model

The image below shows the conceptual model of the TaskGt project, illustrating the entities and their relationships within the system.

![conceptual_model](./assets/images/conceptual_model.png)


## 🗂️ Logic Model

The image below shows the logic model of the TaskGt project, illustrating the tables and their attributes.

![logic_model](./assets/images/logic_modeling.png)


## 🗂️ Fisic Model

``` bash
###tb_user
 CREATE TABLE tb_user (
    user_id VARCHAR(36) PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(50),
    password VARCHAR(50)
);
```

```bash
### tb_role
CREATE TABLE tb_role (
    role_id BIGINT PRIMARY KEY,
    name VARCHAR(50)
);
```
```bash
### tb_role_user
CREATE TABLE tb_role_user (
    role_id BIGINT,
    user_id VARCHAR(36)
);
 
ALTER TABLE tb_role_user ADD CONSTRAINT FK_tb_role_user_1
    FOREIGN KEY (role_id)
    REFERENCES tb_role (role_id);
 
ALTER TABLE tb_role_user ADD CONSTRAINT FK_tb_role_user_2
    FOREIGN KEY (user_id)
    REFERENCES tb_user (user_id);
```
```bash
###tb_task
CREATE TABLE tb_task (
    task_id BIGINT PRIMARY KEY,
    title VARCHAR(50),
    description VARCHAR(100),
    status VARCHAR(36),
    priorite VARCHAR(50),
    deadline DATE,
    user_id VARCHAR(36)
);
 
ALTER TABLE tb_task ADD CONSTRAINT FK_tb_task_2
    FOREIGN KEY (user_id)
    REFERENCES tb_user (user_id)
    ON DELETE CASCADE;

```


<!-- ## 🔧 Configuração de perfis
Este projeto utiliza perfis para diferentes ambientes:
- `dev`: já vem configurado no repositório (H2).
- `test`: usado para testes automatizados.
- `prod`: você pode criar um `application-prod.properties` baseado no arquivo `application-prod.example.properties`. -->


<!-- ## 🚀 Começando


usar o ``` bash comando``` 



### 📋 Pré-requisitos

### 🔧 Instalação

## ⚙️ Executando os testes/Instrucoes de uso  

### ⌨️ E testes de estilo de codificação -->

## ✒️ Author

- [Matheus Lustosa](https://github.com/SEU_USUARIO)


<!-- ## 📄 Licença -->

<!-- ## Contributing -->


<!-- 1. CMD (Prompt de Comando do Windows)
cmd
Copy
Edit
javac -d out src\main\java\com\jwt\jwtWIthDetails\Config\RSAGenerator.java
java -cp out com.jwt.jwtWIthDetails.Config.RSAGenerator
2. PowerShell (Windows)
powershell
Copy
Edit
javac -d out src\main\java\com\jwt\jwtWIthDetails\Config\RSAGenerator.java
java -cp out com.jwt.jwtWIthDetails.Config.RSAGenerator
Dica: Use barra invertida \ para caminhos, igual no CMD. Se der problema, tente colocar aspas no -cp:

powershell
Copy
Edit
java -cp "out" com.jwt.jwtWIthDetails.Config.RSAGenerator
3. Linux (Terminal Bash)
bash
Copy
Edit
javac -d out src/main/java/com/jwt/jwtWIthDetails/Config/RSAGenerator.java
java -cp out com.jwt.jwtWIthDetails.Config.RSAGenerator -->


