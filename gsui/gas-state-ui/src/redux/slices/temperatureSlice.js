import { createSlice } from '@reduxjs/toolkit';

export const temperatureSlice = createSlice({
  name: 'temperature',
  initialState: {
    value: '',
  },
  reducers: {
    updateTemperature: (state, action) => {
      state.temperature = action.payload;
    },
  },
});

export const { updateTemperature } = temperatureSlice.actions;

export default temperatureSlice.reducer;
