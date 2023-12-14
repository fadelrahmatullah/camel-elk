# camel-elk
RestfullAPI Application Transfer File Doc use Apache Camel with monitoring log use ELK(Elasticsearch, Logstash, Kibana)

application specifications: 
1. java version: 8
2. Database using h2
3. technology : JpaRepository, JdbTemplate camel, activeMQ, ELK

API Access:
localhost:8020/elk-camel/api/main/v1/csv/produce-camel

Database Access:
http://localhost:8020/elk-camel/api/main/v1/h2-console
JDBC URL: jdbc:h2:mem:db
username: admin
pass: admin123

NOTED:
- If you want to use ELK, here are the steps: 
    1. install docker if not already there
    2. in my repo there is already docker-compose.yml up docker compose "docker-compose up -d" a little long because the image I use from the original ELK
    3. if it runs smoothly the ELK container already exists, open your browser "http://localhost:5601/"
    4. if the browser opens ELK it means it is successful
    5. in the logback-spring.xml file codingan open coment config logstash
    6. then run the spring-boot application, if the error can ask me
