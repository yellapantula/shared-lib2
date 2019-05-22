
def coveragepercentage
def testFunc(){

    def param = "${env:TestCoverage}"
    echo param
    def paramInt = param as int
    echo "Integer "+ paramInt
    def jsondata = readFile(file:'./target/site/munit/coverage/munit-coverage.json')
           def data = new JsonSlurperClassic().parseText(jsondata)
           coveragepercentage = data.coverage
           echo "${coveragepercentage}"

        if(coveragepercentage > paramInt){
           println("This value is smaller")
           sh "exit 1"
           currentBuild.result = 'FAILURE'
                }
}

