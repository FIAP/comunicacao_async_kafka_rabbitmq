# Kafka and RabbitMQ

Este repositório contém materiais e exemplos práticos relacionados à matéria de Comunicação Assíncrona com Kafka e RabbitMQ, desenvolvidos para a turma ADJT.

## Quick Start com Kafka

### Iniciar um broker Kafka:
```bash
docker run -d --name broker apache/kafka:latest
```

### Abrir um shell no container do broker:
```bash
docker exec --workdir /opt/kafka/bin/ -it broker sh
```

### Criar um tópico chamado `test-topic`:
```bash
./kafka-topics.sh --bootstrap-server localhost:9092 --create --topic test-topic
```

### Produzir eventos no tópico `test-topic`:
```bash
./kafka-console-producer.sh --bootstrap-server localhost:9092 --topic test-topic
```
No prompt `>`, insira:
```
hello
world
```
Pressione `Ctrl+C` para sair.

### Consumir eventos do tópico `test-topic`:
```bash
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test-topic --from-beginning
```
Saída esperada:
```
hello
world
```

## Comandos úteis para tópicos Kafka

### Criar um tópico chamado `hello-world`:
```bash
kafka-topics.sh --bootstrap-server localhost:9092 --topic hello-world --create
```

### Listar todos os tópicos:
```bash
kafka-topics.sh --bootstrap-server localhost:9092 --list
```

### Descrever um tópico:
```bash
kafka-topics.sh --bootstrap-server localhost:9092 --topic hello-world --describe
```

### Deletar um tópico:
```bash
kafka-topics.sh --bootstrap-server localhost:9092 --topic hello-world --delete
```

### Criar um tópico com partições:
```bash
kafka-topics.sh --bootstrap-server localhost:9092 --topic order-events --create --partitions 2
```

### Criar um tópico com fator de replicação:
```bash
kafka-topics.sh --bootstrap-server localhost:9092 --topic order-events --create --replication-factor 3
```

## Mapas Mentais

- [Kafka](https://miro.com/app/board/uXjVLm7xhR8=/?share_link_id=912891690132)
- [RabbitMQ](https://miro.com/app/board/uXjVLlS0FuM=/?share_link_id=287292532402)
- [Fundamentos de Mensageria](https://miro.com/app/board/uXjVLnSMc78=/?share_link_id=98935662991)
