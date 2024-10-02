j = "common"

function RNG(n)
    n = math.random(1000000)
    if n < 100000 then
        return j
    end 
    if n >= 100000 and n < 300000 then
        j = "uncommon"
        return j
    end
end
