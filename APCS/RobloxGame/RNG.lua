j = "common"

-- Define rarity tiers and their probabilities
local rarities = {
    {tier = "common", chance = 0.10},      -- 10% chance
    {tier = "uncommon", chance = 0.20},    -- 20% chance
    {tier = "rare", chance = 0.30},        -- 30% chance
    {tier = "epic", chance = 0.20},        -- 20% chance
    {tier = "legendary", chance = 0.15},   -- 15% chance
    {tier = "mythic", chance = 0.05}       -- 5% chance
}

function RNG()
    local roll = math.random()  -- Random number between 0 and 1
    local cumulative = 0

    for _, rarity in ipairs(rarities) do
        cumulative = cumulative + rarity.chance
        if roll <= cumulative then
            j = rarity.tier
            return j  -- Return the rarity that matches the random roll
        end
    end
end

print(RNG())  -- Testing the function
print(j)      -- Print the global j to see the final value
