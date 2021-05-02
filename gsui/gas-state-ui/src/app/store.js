import { configureStore } from '@reduxjs/toolkit';
import inputsReducer from '../redux/slices/inputSlice';
import tableReducer from '../redux/slices/tableSlice';

export default configureStore({
  reducer: {
    inputs: inputsReducer,
    table: tableReducer,
  },
});
