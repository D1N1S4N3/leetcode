package leetcodeChallenge.dividePlayer

import java.lang.IllegalArgumentException

class Solution{
    data class Team (val p1 : Int, val p2 : Int)
    fun dividePlayers(skill:IntArray):Int{
        var usableArray = skill.toMutableList()
        val totalSize = skill.size
        val totalTeams = totalSize / 2
        val skillValue = skill.sum() / totalTeams
        var teamList = emptyList<Team>()
        for (p1Index in usableArray.indices){
            var p2Index = p1Index +1
            while (p2Index <= usableArray.size-1 ){
                if (usableArray[p1Index] + usableArray[p2Index] == skillValue){
                    val p1 = usableArray[p1Index]
                    val p2 = usableArray[p2Index]
                    teamList + Team(p1, p2)
                    usableArray.removeAt(p1Index)
                    usableArray.removeAt(p2Index)
                }
                else{
                    return -1
                }
                p2Index ++
            }
        }
        //calculates the output
        var output = 0
        for (i in teamList.indices){
            output += teamList[i].p1 * teamList[i].p2
        }
        return output
    }


}

fun main (){
    val sol = Solution()
    print(sol.dividePlayers(intArrayOf(3,2,5,1,3,4)))
}
/*
                    if (p1Index != skill.size-1 && p2Index != skill.size-1){
                        usableArray = usableArray.sliceArray(0 until p1Index) + usableArray.sliceArray(p1Index+1 until usableArray.size-1)
                        usableArray = usableArray.sliceArray(0 until p2Index) + usableArray.sliceArray(p2Index + 1 until usableArray.size-1)
                    }
                    if (p1Index == skill.size-1 && p2Index != skill.size-1){
                        usableArray= usableArray.sliceArray(0 until p1Index)
                        usableArray = usableArray.sliceArray(0 until p2Index) + usableArray.sliceArray(p2Index+1 until usableArray.size-1)
                    }
                    if (p2Index == skill.size-1 && p1Index != skill.size-1){
                        usableArray= usableArray.sliceArray(0 until p2Index)
                        usableArray = usableArray.sliceArray(0 until p1Index) + usableArray.sliceArray(p1Index+1 until usableArray.size-1)
                    }*/