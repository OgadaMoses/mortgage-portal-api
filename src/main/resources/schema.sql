---------1. Roles---------------------------------------------------------------------------------------------------------------------------
CREATE TABLE roles (
    idxno SERIAL PRIMARY KEY,                
    role_id VARCHAR(50) NOT NULL UNIQUE,     
    role_description VARCHAR(255) NOT NULL   
);

---------2. Users Table---------------------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE users (
    idxno SERIAL PRIMARY KEY,                        
    username VARCHAR(100) NOT NULL UNIQUE,          
    userIdentificationNumber VARCHAR(50) NOT NULL UNIQUE, 
    password VARCHAR(255) NOT NULL,                 
    email VARCHAR(150) NOT NULL UNIQUE,             
    roleid VARCHAR(50) NOT NULL,                  
    createdAt TIMESTAMP NOT NULL DEFAULT NOW(),    
    updatedAt TIMESTAMP NOT NULL DEFAULT NOW(),     
    activeStatus BOOLEAN NOT NULL DEFAULT TRUE,     
    lastLogin TIMESTAMP,                             
    isPasswordExpired BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_role FOREIGN KEY (roleid) REFERENCES roles(role_id)
);


---3. MenuRoles Mapping------------------------------------------------------------------------------------------------------------
CREATE TABLE RoleMenuMappings (
    idxno SERIAL PRIMARY KEY,                      
    menuName VARCHAR(100) NOT NULL,                
    menuID VARCHAR(50) NOT NULL UNIQUE,            
    roleID VARCHAR(50) NOT NULL,                   
    CONSTRAINT fk_role_menu FOREIGN KEY (roleID) REFERENCES roles(role_id)
);


----4. AdminUserMapping-------------
CREATE TABLE AdminUserMapping (
    idxno SERIAL PRIMARY KEY,
    adminIdentificationNumber VARCHAR(50) NOT NULL UNIQUE,
    userIdentificationNumbers JSONB NOT NULL        
);


----5. LoanApplication----------
CREATE TABLE LoanApplications (
    idxno SERIAL PRIMARY KEY,                             
    fullNames VARCHAR(150) NOT NULL,                     
    email VARCHAR(150) NOT NULL,                         
    phoneNumber VARCHAR(20) NOT NULL,                    
    idPassportNumber VARCHAR(50) NOT NULL,               
    nationality VARCHAR(50) NOT NULL,                 
    countryResidence VARCHAR(50) NOT NULL,                
    countyResidence VARCHAR(50) NOT NULL,                
    netMonthlyIncome NUMERIC(12,2) NOT NULL,              
    loanAmount NUMERIC(15,2) NOT NULL,                    
    loanTenure INT NOT NULL,                             
    documentUrls TEXT[] DEFAULT '{}',                   
    loanAppId VARCHAR(20) NOT NULL UNIQUE,               
    loanStatus VARCHAR(20) NOT NULL DEFAULT 'PENDING',   
    applicationDate TIMESTAMP NOT NULL DEFAULT NOW(),     
    approRejectionDate TIMESTAMP,                        
    userIdentificationNumber VARCHAR(50) NOT NULL,        
    checkerAdminId VARCHAR(50),                           
    CONSTRAINT fk_user FOREIGN KEY (userIdentificationNumber) REFERENCES users(userIdentificationNumber),
    CONSTRAINT fk_checker FOREIGN KEY (checkerAdminId) REFERENCES users(userIdentificationNumber)
);


select * from roles

