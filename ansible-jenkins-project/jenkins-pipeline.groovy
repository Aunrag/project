pipeline{
    agent any
    environment{
        GIT_REPO='https://github.com/Aunrag/front-end-study.git'
        BRANCH='main'
        ANSIBLE_INVENTORY='/etc/ansible/hosts'
        ANSIBLE_PLAYBOOK='/etc/ansible/playbooks/3_jjkfilesmv.yml'
        ANSIBLE_PLAYBOOK1='/etc/ansible/playbooks/4_jjkwebset.yml'
        RECIPIENTS='pawaranurag244@gmail.com'
    }
    triggers {
        pollSCM('* * * * *')
    }
    stages{
        stage('checkout the code'){
            steps{
                echo "checking out the code from github"
                git branch: BRANCH , url: GIT_REPO
            }
        }
        stage('run ansiblen playbook'){
            steps{
                echo "runnig ansivle playbook to transefer code to another server"
                sh "ansible-playbook -i ${ANSIBLE_INVENTORY} ${ANSIBLE_PLAYBOOK} -vvvv "
                
            }
        }
        stage('run 2nd ansible playbook'){
            steps{
                echo "running ansible playbook to run httpd service"
                sh "ansible-playbook -i ${ANSIBLE_INVENTORY} ${ANSIBLE_PLAYBOOK1}"
            }
        }
    }
    post{
        success{
            echo "sending email for successful build"
            emailext( 
                subject:"build is successful",
                body:"Good the build is successful.",
                to: RECIPIENTS
                )
        }
        failure{
            echo "sending email for failed build"
            emailext(
                subject:"build is failed.",
                body:"ohh build is failed.",
                to:RECIPIENTS
                )
        }
    }
    
}