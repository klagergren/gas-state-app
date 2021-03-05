import { createSlice } from '@reduxjs/toolkit';

export const temperatureSlice = createSlice({
  name: 'temperature',
  initialState: {
    value: '',
  },
  reducers: {
    updateTemperature: (state, action) => {
      console.log(action.payload);
      state.value = action.payload;
    },
  },
});

export const { updateTemperature } = temperatureSlice.actions;

export default temperatureSlice.reducer;
