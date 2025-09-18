class FoodRatings {
    private Map<String, TreeSet<Pair<String, Integer>>> cuisineToFood;
    private Map<String, String> foodToCuisineMap;
    private Map<String, Integer> foodToRatingMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineToFood = new HashMap<>();
        foodToCuisineMap = new HashMap<>();
        foodToRatingMap = new HashMap<>();

        int n = foods.length;

        for (int i = 0; i < n; i++) {
            if (!cuisineToFood.containsKey(cuisines[i])) {
                cuisineToFood.put(cuisines[i], new TreeSet<>((a, b) -> {
                    int rating = b.getValue() - a.getValue();
                    if (rating != 0)
                        return rating;
                    return a.getKey().compareTo(b.getKey());
                }));

                cuisineToFood.get(cuisines[i]).add(new Pair<>(foods[i], ratings[i]));
            } else {
                cuisineToFood.get(cuisines[i]).add(new Pair<>(foods[i], ratings[i]));
            }
            foodToCuisineMap.put(foods[i], cuisines[i]);
            foodToRatingMap.put(foods[i], ratings[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisineMap.get(food);
        int rating = foodToRatingMap.get(food);

        TreeSet<Pair<String, Integer>> set = cuisineToFood.get(cuisine);
        set.remove(new Pair<>(food, rating));
        foodToRatingMap.put(food, newRating);
        cuisineToFood.get(cuisine).add(new Pair<>(food, newRating));
    }

    public String highestRated(String cuisine) {
        return cuisineToFood.get(cuisine).first().getKey();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

//  Iterator<Pair<String, Integer>> it = set.iterator();
//     while (it.hasNext()) {
//         Pair<String, Integer> element = it.next();
//         if (element.getKey().equals(food)) {
//             it.remove();
//             break; // only one match, can break early
//         }
//     }

// cuisineToFood.putIfAbsent(cuisines[i], new TreeSet<>((a, b) -> {
//             int ratingCompare = Integer.compare(b.getValue(), a.getValue());
//             if (ratingCompare != 0) return ratingCompare;
//             return a.getKey().compareTo(b.getKey());
//         }));