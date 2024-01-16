FROM node:21-alpine3.19

WORKDIR /app
COPY package*.json .
RUN npm i --silent

COPY . .

ARG API_URL
ENV API_URL=$API_URL

EXPOSE 4200


CMD ["npm", "run", "start"]
