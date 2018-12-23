package CheckPossibility;

class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean sequence_result = true;
        boolean inverse_result = true;

        int[] temp_nums = nums.clone();
        int modifyNum = 0;

        for(int i = temp_nums.length - 1;i > 0;i--){
            int min = temp_nums[i];

            for(int j = i - 1;j >= 0;j--){
                if(temp_nums[i] < temp_nums[j]){
                    if(modifyNum == 0){
                        modifyNum++;
                        temp_nums[j] = min;
                    }else if(modifyNum != 0){
                        inverse_result = false;
                        break;
                    }
                }else{
                    min = temp_nums[j];
                }
            }
        }

        temp_nums = nums.clone();
        modifyNum = 0;

        for(int i = 0;i < temp_nums.length - 1;i++){
            int max = temp_nums[i];

            for(int j = i + 1;j < temp_nums.length;j++){
                if(temp_nums[i] > temp_nums[j]){
                    if(modifyNum == 0){
                        modifyNum++;
                        temp_nums[j] = max;
                    }else if(modifyNum != 0){
                        sequence_result = false;
                        break;
                    }
                }else{
                    max = temp_nums[j];
                }
            }
        }

        return sequence_result || inverse_result;
    }
}