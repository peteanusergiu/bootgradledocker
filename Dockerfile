FROM niaquinto/gradle:2.5
EXPOSE 8082
#EXPOSE 8082 1043
#ENV JAVA_OPTS="-agentlib:jdwp=transport=dt_socket,address=1043,suspend=n,server=y"
CMD ["bootRun"]