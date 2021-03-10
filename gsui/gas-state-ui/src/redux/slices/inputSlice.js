import { createSlice } from '@reduxjs/toolkit';

export const inputsSlice = createSlice({
  name: 'gasStateInput',
  initialState: {
    temperature: '',
    pressure: '',
  },
  reducers: {
    updateInput: (state, action) => {
      state[action.payload.inputType] = action.payload.inputValue;
    },
  },
});

export const { updateInput } = inputsSlice.actions;

export default inputsSlice.reducer;
