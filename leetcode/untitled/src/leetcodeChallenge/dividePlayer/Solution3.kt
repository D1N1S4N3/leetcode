package leetcodeChallenge.dividePlayer

class Solution3 {

    fun dividePlayers(skill : IntArray):Long{
        skill.sort()
        val size = skill.size
        var i = 0
        var j = size -1
        var ret :Long = 0
        val medium = skill.sum() / (size / 2)
        while (i < skill.size/2 ){
            if (skill[i] + skill[j] == medium){
                ret += skill[i] * skill[j]
            }else{
                return -1
            }
            i++
            j--

        }
        return ret
    }

}
fun main(){
    print("\n")
    val sol = Solution3()
    val arr = intArrayOf(3,2,5,1,3,4)
    sol.dividePlayers(arr)
    print(sol.dividePlayers(arr))

}