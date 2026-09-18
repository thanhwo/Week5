`timescale 1ns/1ps
module lab1_top_tb;

logic a;
logic y;

lab1_top dut (a, y);
initial begin
a = 1'b0;
#10;

a = 1'b1;
#10;

a = 1'b0;
#10;

a = 1'b1;
#10;

$stop;
end

endmodule