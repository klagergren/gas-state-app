import { createSlice } from '@reduxjs/toolkit';

export const tableSlice = createSlice({
  name: 'resultsTable',
  initialState: {
    rows: [],
  },
  reducers: {
    addRow: (state, action) => {
      state.rows.push(action.payload);
    },
  },
});

export const { addRow } = tableSlice.actions;

export default tableSlice.reducer;
