# ----------------------------#
#					UI BUILD 						#
# ----------------------------#
FROM node:12-alpine as webappbuild

RUN npm install -g @angular/cli

RUN mkdir /webapp

WORKDIR /webapp

COPY webApp/package.json /webapp/

RUN npm install

COPY webApp/* /webapp/

RUN ng build --prod --delete-output-path --output-path=/webapp/dist

# ----------------------------#
#					JAVA BUILD 					#
# ----------------------------#
FROM maven:3.6-jdk-12 as webappserverbuild

RUN mkdir /webappserver

WORKDIR /webappserver

COPY pom.xml /webappserver/

# Expected to download dependencies but not build
RUN mvn -b dependency:go-offline

# Now copy actual source, i.e., this line should be after downloading dependencies to avoid repeated download when src changes
COPY ./src /webappserver/

# Build now
RUN mvn -b -q clean package -DskipTests=true

COPY --from=webappbuild /webapp/dist/* /webappserver/main/static/

RUN ls -ltr /webappserver/main/static/

ENTRYPOINT ["mvn", "spring-boot:run"]