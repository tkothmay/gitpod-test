FROM gitpod/workspace-full

USER gitpod

# Ensure Java 21 LTS is used
RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install java 21-zulu && \
    sdk default java 21-zulu"