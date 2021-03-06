import { createSlice } from '@reduxjs/toolkit';

export const inputSlice = createSlice({
  name: 'gasStateInput',
  initialState: {
    value: '',
  },
  reducers: {
    updateInput: (state, action) => {
      // console.log(action.payload);
      state.value = action.payload;
    },
  },
});

export const { updateInput } = inputSlice.actions;

export default inputSlice.reducer;
