<h1 align="center" style="font-weight: bold;"> Election 💻</h1>

<p align="center">
 <a href="#tech">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
 <a href="#routes">API Documentation (Swagger)</a> 
</p>

<p align="center">
    <b>This project is built using Java, Quarkus, mariadb as relational database and redis as NoSQL </b>
</p>
This project is a system for election.

- Candidates are listed, registered and edited
- All registered candidates participate in an election when it begins
- Candidates receive votes from voters
- Result available in real time

<h2 id="technologies">💻 Technologies</h2>

- Java
- Quarkus
- MariaDB
- Redis
- Docker e Docker compose
- Traefik
- Graylog
- MongoDB
- OpenSearch
- Jaeger Tracing
- Junit e Mockito

<h3>Architectural proposal</h3>

![proposal](https://github.com/seanycarol/pass-in/assets/38301491/e7fa80af-47df-4b5a-a1d5-94a29bf50ed1)

<h2 id="started">🚀 Getting started</h2>

Here you describe how to run your project locally


<h3>Installation</h3>

1. Clone the repository:

```bash
git clone https://github.com/seanycarol/lab-quarkus.git
```
2. Install docker and docker compose
3. Install dependencies with Maven

<h3>Usage</h3>

1. Open lab-quarkus folder in terminal, run each docker compose in sequence  
```bash
docker compose up -d reverse-proxy
```
```bash
docker compose up -d jaeger
```
```bash
docker compose up -d mongodb opensearch
```
```bash
docker compose up -d graylog
```
```bash
curl -H "Content-Type: application/json" -H "Authorization: Basic YWRtaW46YWRtaW4=" -H "X-Requested-By: curl" -X POST -v -d '{"title":"udp input","configuration":{"recv_buffer_size":262144,"bind_address":"0.0.0.0","port":12201,"decompress_size_limit":8388608},"type":"org.graylog2.inputs.gelf.udp.GELFUDPInput","global":true}' http://logging.private.dio.localhost/api/system/inputs
```
```bash
docker compose up -d caching database
```
2. Start applications with Maven:
```bash
./mvnw compile quarkus:dev
```

<h2 id="routes">📍 API Documentation (Swagger)</h2>

For API documentation, visit the link:
  
- election-management: [http://localhost:8080/q/swagger-ui/](http://localhost:8080/q/swagger-ui/)
![election-management](https://github.com/seanycarol/pass-in/assets/38301491/6d7f0319-bb07-456e-87d9-ee7de864b6c4)

- voting-app: [http://localhost:8080/q/swagger-ui/](http://localhost:8080/q/swagger-ui/)
![voting-app](https://github.com/seanycarol/pass-in/assets/38301491/a2c9d7e4-e050-4dd8-aaa0-3128cdea2484)

- result-app: [http://localhost:8081/q/swagger-ui/](http://localhost:8080/q/swagger-ui/)
![result-app](https://github.com/seanycarol/pass-in/assets/38301491/1396ed62-582d-41b7-b521-31653f5ebaf3)
