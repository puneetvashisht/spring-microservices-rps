FROM node:carbon
WORKDIR /workdir/app
COPY package.json /workdir/app
RUN npm install
COPY . /workdir/app
EXPOSE 3000
CMD ["npm", "start"]
