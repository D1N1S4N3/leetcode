package leetcodeChallenge.dividePlayer

class Solution2{
    data class Team (val p1:Int, val p2:Int)
    fun dividePlayers(skill : IntArray):Long {
        val skillSize = skill.size
        val usableArray  = skill
        usableArray.sort()
        var usableList = usableArray.toList()
        var teamList = emptyList<Team>()
        var i = 0
        var j = skillSize -1
        while(i < skillSize/2){
            teamList += Team(usableList[i], usableList[j])
            i ++
            j --
        }
        val sum = usableList.sum()/(skillSize/2)
        var retInt :Long = 0
        for (i in teamList.indices) {
            if (teamList[i].p1 + teamList[i].p2 != sum) {
                return -1
            }
            else retInt += teamList[i].p1 * teamList[i].p2
        }
        return retInt
    }
}

fun main (){
    val sol = Solution2()
    print(sol.dividePlayers(intArrayOf(3,2,5,1,3,4)))
}