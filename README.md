# TravelAPI

TravelAPI project provides RESTful API for getting information about different places.

This project was written as a part of the test task for the Java Junior Developer position.

## AWS infrastructure and deployment process

I've configured CI/CD pipline using GitHub Actions. You can find workflow file in **.github/workflows/aws-deploy.yml**
On **git push** into the **master** branch updated Docker container is being deployed to AWS Elastic Beanstalk service.

### API base url

> http://travelapi-env.eba-xmtprpjv.us-east-2.elasticbeanstalk.com/


### Places resource url

> http://travelapi-env.eba-xmtprpjv.us-east-2.elasticbeanstalk.com/places

## Places resource profile data (detailed description of the Profile resource)

> http://travelapi-env.eba-xmtprpjv.us-east-2.elasticbeanstalk.com/profile/places

## Search by name url

> http://travelapi-env.eba-xmtprpjv.us-east-2.elasticbeanstalk.com/places/search/findByNameIgnoreCase?name=<NAME_PARAM>
 