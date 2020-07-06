export const initialState = 0;

export const COUNT_PLUS = 'COUNT_PLUS';
export const COUNT_MINUS = 'COUNT_MINUS';

export const countPlusAction = () => ({
    type: COUNT_PLUS
});

export const countMinusAction = () => ({
    type: COUNT_MINUS
});

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case COUNT_PLUS:
            return state + 1;
        case COUNT_MINUS:
            return state - 1;
        default:
            return state;
    }
};

export default reducer;