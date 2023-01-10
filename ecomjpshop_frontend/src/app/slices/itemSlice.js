import { createSlice } from '@reduxjs/toolkit'
import { itemService } from '../services/itemService';

const initialState = {
    items : []
}

const itemSlice = createSlice({
  name: "item",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder.addMatcher(itemService.endpoints.getItems.matchFulfilled, (state, action) => {
        state.items = action.payload;
    })
    builder.addMatcher(itemService.endpoints.deleteItem.matchFulfilled, (state, action) => {
        let index = state.items.findIndex(item => item.id === action.payload);
            state.items.splice(index, 1);
    })
}
});

export const {} = itemSlice.actions

export default itemSlice.reducer