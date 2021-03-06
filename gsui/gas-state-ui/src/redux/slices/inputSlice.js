import { createSlice } from '@reduxjs/toolkit';

export const inputSlice = createSlice({
  name: 'gasStateInput',
  initialState: {
    inputs: {
      temperature: '',
      pressure: '',
    },
  },
  reducers: {
    updateInput: (state, action) => {
      state.inputs[action.payload.inputType] = action.payload.inputValue;
    },
  },
});

export const { updateInput } = inputSlice.actions;

export default inputSlice.reducer;
