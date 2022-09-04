class Solution {
public:
    int minOperations(vector<string>& logs) {
        int no_op = logs.size();
        if(no_op == 0)
            return 0;
        int level = 0;
        if(logs[0] == "../" || logs[0] == "./")
            level = 0;
        else
            level = 1;
        for(int i = 1; i < no_op; i++){
            if(logs[i] == "../"){
                if(level != 0)
                    level -= 1;
                else
                    continue;
            }
            else if(logs[i] == "./")
                continue;
            else
                level += 1;
        }
        return level;
    }
};