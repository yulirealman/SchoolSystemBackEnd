FROM centos:7

COPY jdk25.tar.gz /usr/local/
RUN tar -xzf /usr/local/jdk25.tar.gz -C /usr/local/&& rm -f /usr/local/jdk25.tar.gz

ENV JAVA_HOME=/usr/local/jdk-25.0.1
ENV PATH=$JAVA_HOME/bin:$PATH


ENV LANG=en_US.UTF-8
ENV LANGUAGE=en_US:en
ENV LC_ALL=en_US.UTF-8


RUN mkdir -p /schoolsystem
WORKDIR /schoolsystem

COPY schoolsystem.jar schoolsystem.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "/schoolsystem/schoolsystem.jar" ]
